import React, { Component } from 'react';
import { signup } from '../../util/APIUtils';
import { notification } from 'antd';
import { Button, Card, CardBody, Col, Container, Form, Input, InputGroup, Row } from 'reactstrap';

class Register extends Component {
    constructor() {
        super();
        this.state = {
            username: '',
            email: '',
            password: ''
        }
    }

    onChange = (event) => {
        var target = event.target;
        var name = target.name;
        var value = target.value;
        this.setState({
            [name]: value
        });
    }

    register = (event) => {
        event.preventDefault();
        const signupRequest = {
            email: this.state.email,
            username: this.state.username,
            password: this.state.password
        };
        signup(signupRequest)
            .then(response => {
                notification.success({
                    message: 'Devices Management App',
                    description: "Thank you! You're successfully registered. Please Login to continue!",
                });
                this.props.history.push("/login");
            }).catch(error => {
                notification.error({
                    message: 'Devices Management App',
                    description: error.message || 'Sorry! Something went wrong. Please try again!'
                });
            });
    }

    render() {
        return (
            <div className="app flex-row align-items-center" style={{ marginTop: 50 }}>
                <Container>
                    <Row className="justify-content-center">
                        <Col md="9" lg="7" xl="6">
                            <Card className="mx-4">
                                <CardBody className="p-4">
                                    <Form className="splash-container">
                                        <div className="row" className="mb-2 pageheading">
                                            <div className="col-sm-12 btn btn-primary">
                                                Register
                                            </div>
                                        </div>
                                        <InputGroup className="mb-3">
                                            <Input type="text" name="email" value={this.state.email} onChange={this.onChange} placeholder="Enter Email" />
                                        </InputGroup>
                                        <InputGroup className="mb-3">
                                            <Input type="text" name="username" value={this.state.username} onChange={this.onChange} placeholder="Enter Username" />
                                        </InputGroup>
                                        <InputGroup className="mb-3">
                                            <Input type="password" name="password" value={this.state.password} onChange={this.onChange} placeholder="Enter Password" />
                                        </InputGroup>
                                        <Button className="btn btn-block btn-primary" onClick={this.register} color="success" block>Create Account</Button>
                                    </Form>
                                </CardBody>
                            </Card>
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default Register;