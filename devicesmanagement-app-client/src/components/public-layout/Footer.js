import React from "react";
import { NavLink } from "react-router-dom";

function Footer() {
    return (
        <nav className="line">
            <NavLink to={'#'}>Copyright 2019, River</NavLink>
        </nav>
    );
}

export default Footer;