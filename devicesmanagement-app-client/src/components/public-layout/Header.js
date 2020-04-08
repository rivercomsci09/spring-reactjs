import React from "react";
import Logo from "../../images/logo.png";
import { Form, Button, Navbar, NavbarBrand, Nav, NavLink } from 'reactstrap';

function Header() {
    return (
        <nav>
            <div className="s-12 l-2">
                <img className="s-5 l-12 center" src={Logo} alt="logo" />
			</div>
                <Navbar bg="primary" variant="dark">
                    <NavbarBrand href="#home">Navbar</NavbarBrand>
                    <Nav className="mr-auto">
                        <NavLink href="#home">Home</NavLink>
                        <NavLink href="#features">Product</NavLink>
                        <NavLink href="#pricing">Company</NavLink>
                        <NavLink href="#pricing">Contact</NavLink>
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