import React, { Component } from 'react';
import '../App.css';
import { Button, Card, CardBody, CardGroup, Col, Container, Form, Input, InputGroup, InputGroupAddon, InputGroupText, Row } from 'reactstrap';
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
        // debugger;
        fetch('http://localhost:8080/login', {
            method: 'post',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: this.state.username,
                password: this.state.password
            })
        }).then((Response) => Response.json())
            .then(
                console.log(Response)
                // (result) => {
                //     console.log(result);
                //     if (result.Status == 'Invalid')
                //         alert('Invalid User');
                //     else
                //         this.props.history.push("/Dashboard");
                // }

            )
    }

    render() {

        return (
            <div className="app flex-row align-items-center" style={{ marginTop: 50 }}>
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
                                                <Input type="password" name="password" value={this.state.password} onChange={this.Password} placeholder="Enter Password" />
                                            </InputGroup>
                                            <Button onClick={this.login} color="success" block>Login</Button>
                                        </Form>
                                    </CardBody>
                                </Card>
                            </CardGroup>
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }

}

export default Login; 