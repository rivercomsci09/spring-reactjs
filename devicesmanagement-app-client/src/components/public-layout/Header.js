import React from "react";
import Logo from "../../images/logo.png";
import { Form, Button, Collapse, Navbar, NavbarToggler, NavbarBrand, Nav, NavItem, NavLink } from 'reactstrap';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

function Header() {
    return (
        <nav>
            <div class="s-12 l-2">
                <img class="s-5 l-12 center" src={Logo} />
			</div>
                <Navbar bg="primary" variant="dark">
                    <NavbarBrand href="#home">Navbar</NavbarBrand>
                    <Nav className="mr-auto">
                        <NavLink href="#home">Home</NavLink>
                        <NavLink href="#features">Product</NavLink>
                        <NavLink href="#pricing">Company</NavLink>
                        <NavLink href="#pricing">Contact</NavLink>
                        <Link to={'/login'} className="nav-link">Login</Link>
                        <Link to={'/register'} className="nav-link">Sign Up</Link>
                    </Nav>            
                    <Form inline>
                        {/* <Form.Control type="text" placeholder="Search" className="mr-sm-2" /> */}
                        <Button variant="outline-light">Search</Button>
                    </Form>
                </Navbar>
        </nav>
            );
        }
export default Header;