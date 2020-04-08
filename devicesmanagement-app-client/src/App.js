import React, { Component } from 'react';
import './App.css';
import {Route, Redirect, Switch, Router } from 'react-router-dom';

/** Components **/
import Index from "./components/Index";
import Register from "./components/user/Register";
import Login from "./components/user/Login";
import Dashboard from "./components/user/Dashboard";
import { Layout, notification } from "antd";
import { getCurrentUser } from './util/APIUtils';
import { ACCESS_TOKEN } from './constants';
import { history } from './helpers/history';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            currentUser: null,
            isAuthenticated: false,
            isLoading: false
        }
        this.handleLogout = this.handleLogout.bind(this);
        this.loadCurrentUser = this.loadCurrentUser.bind(this);
        this.handleLogin = this.handleLogin.bind(this);

        notification.config({
            placement: 'topRight',
            top: 70,
            duration: 3,
        });
    }

    loadCurrentUser() {
        this.setState({
            isLoading: true
        });
        getCurrentUser()
            .then(response => {
                this.setState({
                    currentUser: response,
                    isAuthenticated: true,
                    isLoading: false
                });
            }).catch(error => {
                this.setState({
                    isLoading: false
                });
            });
    }

    componentDidMount() {
        this.loadCurrentUser();
    }

    handleLogout(redirectTo = "/", notificationType = "success", description = "You're successfully logged out.") {
        localStorage.removeItem(ACCESS_TOKEN);

        this.setState({
            currentUser: null,
            isAuthenticated: false
        });

        this.props.history.push(redirectTo);

        notification[notificationType]({
            message: 'Devices Management App',
            description: description,
        });
    }

    handleLogin() {
        notification.success({
            message: 'Devices Managements App',
            description: "You're successfully logged in.",
        });
        this.loadCurrentUser();
        history.push("/");
    }


    render() {
        return (
            <Layout className="app-container">
                {/* <AppHeader isAuthenticated={this.state.isAuthenticated}
                    currentUser={this.state.currentUser}
                    onLogout={this.handleLogout} /> */}
                <Router history={history}>
                    <Switch>
                        <Route exact path="/">
                            <Redirect to="/index" />
                        </Route>
                        <Route path="/index" component={Index} />
                        <Route path="/register" component={Register} />
                        <Route
                            exact
                            path="/login"
                            render={(props) => <Login onLogin={this.handleLogin} {...props} isAuthed={true} />}
                        />
                        {/* <Route path="/login" component={Login} /> */}
                        <Route path="/dashboard" component={Dashboard} />
                    </Switch>
                </Router>
            </Layout>
        );
    }
}


export default App;
