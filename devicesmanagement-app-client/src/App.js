import React, { Component } from 'react';
import './App.css';

import { BrowserRouter as Router, Route, Redirect, Switch } from 'react-router-dom';

/** Components **/
import Index from "./components/Index";
import Register from './components/Register';
import Login from './components/Login';

class App extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route exact path="/">
                        <Redirect to="/index" />
                    </Route>
                    <Route path="/index" component={Index} />
                    <Route path="/register" component={Register} />
                    <Route path="/login" component={Login} />
                    {/* <LoginLayoutRoute path="/layout1" component={LoginPage} /> */}
                </Switch>
            </Router>
        );
    }
}


export default App;
