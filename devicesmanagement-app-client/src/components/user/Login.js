import React, { Component } from 'react';
import { Button, Card, CardBody, CardGroup, Col, Container, Form, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import { ACCESS_TOKEN } from '../../constants';
import { notification } from 'antd';
import { login } from '../../util/APIUtils';

class Login extends Component {
    constructor() {
        super();
        this.state = {
            username: '',
            password: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }

        this.onChange = this.onChange.bind(this);
        this.login = this.login.bind(this);
    }

    onChange(event) {
        var target = event.target;
        var name = target.name;
        var value = target.value;
        this.setState({
            [name]: value
        });
    }

    login(event) {
        event.preventDefault();
        const loginRequest = {
            username: this.state.username,
            password: this.state.password
        };
        login(loginRequest)
            .then(response => {
                localStorage.setItem(ACCESS_TOKEN, response.accessToken);
                this.props.onLogin();
            }).catch(error => {
                if (error.status === 401) {
                    notification.error({
                        message: 'Devices Managememt App',
                        description: 'Your Username or Password is incorrect. Please try again!'
                    });
                } else {
                    notification.error({
                        message: 'Deviecs Management App Login Page',
                        description: error.message || 'Sorry! Something went wrong. Please try again!'
                    });
                }
            });
        // .then((response) => {
        //     if (response.ok) {
        //         response.json().then(json => {
        //             localStorage.setItem(ACCESS_TOKEN, json.accessToken);
        //             this.props.history.push("/dashboard");
        //         });
        //     } else {
        //         if (response.status === 401) {
        //             notification.error({
        //                 message: 'Polling App',
        //                 description: 'Your Username or Password is incorrect. Please try again!'
        //             });
        //         }
        //     }
        // }).catch(error => {
        //     notification.error({
        //         message: 'Polling App',
        //         description: error.message || 'Sorry! Something went wrong. Please try again!'
        //     });

        // })
    }

    render() {

        return (
            <div className="app flex-row align-items-center" style={{ marginTop: 50 }} >
                <Container>
                    <Row className="justify-content-center">
                        <Col md="9" lg="7" xl="6">
                            <CardGroup>
                                <Card className="p-2">
                                    <CardBody>
                                        <Form>
                                            <div className="row" className="mb-2 pageheading">
                                                <div className="col-sm-12 btn btn-primary">
                                                    Login
                                                </div>
                                            </div>
                                            <InputGroup className="mb-3">
                                                <Input type="text" name="username" value={this.state.username} onChange={this.onChange} placeholder="Enter Username" />
                                            </InputGroup>
                                            <InputGroup className="mb-4">
                                                <Input type="password" name="password" value={this.state.password} onChange={this.onChange} placeholder="Enter Password" />
                                            </InputGroup>
                                            <Button onClick={this.login} color="success" block>Login</Button>
                                            <br />
                                            Or <Link to="/register">register now!</Link>
                                        </Form>
                                    </CardBody>
                                </Card>
                            </CardGroup>
                        </Col>
                    </Row>
                </Container>
            </div >
        );
    }

}

export default Login; 