import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Header from "./public-layout/Header";
import Footer from "./public-layout/Footer";
import { notification, Switch } from 'antd';
import { getCurrentUser } from '../util/APIUtils';
import { ACCESS_TOKEN } from '../constants';
import LoadingIndicator from '../common/LoadingIndicator';
import Dashboard from './user/Dahboard';
import Login from './user/Login';

class Index extends Component {
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
            message: 'Polling App',
            description: description,
        });
    }

    handleLogin() {
        notification.success({
            message: 'Polling App',
            description: "You're successfully logged in.",
        });
        this.loadCurrentUser();
        this.props.history.push("/");
    }

    render() {
        if (this.state.isLoading) {
            return <LoadingIndicator />
        }
        return (
            <div>
                <Link to={'/login'} className="nav-link">Login</Link>
                <Link to={'/register'} className="nav-link">Sign Up</Link>
            </div>
        )
    }

};

export default Index;