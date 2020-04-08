import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Header from "./public-layout/Header";
import Footer from "./public-layout/Footer";

class Index extends Component {
    render() {
        return (
            <div>
                <Header />
                <Link to={'/login'} className="nav-link">Login</Link>
                <Link to={'/register'} className="nav-link">Sign Up</Link>
                <div>Devices Management App</div>
                <Footer />
            </div>
        )
    }

};

export default Index;