import React, { Component } from 'react';
import { Button, Card, CardFooter, CardBody, CardGroup, Col, Container, Form, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';

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
        fetch('http://localhost:8080/api/accounts', {
            method: 'post',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: this.state.username,
                password: this.state.password
            })
        }).then((Response) => {
            if (Response.status == 201)
                this.props.history.push("/Dashboard");
            else
                alert('Sorrrrrry !!!! Un-authenticated User !!!!!')
        })
    }

    render() {
        return (
            <div className="app flex-row align-items-center" style={{marginTop: 50}}>
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