import React, { Component } from 'react';
import Header from "./public-layout/Header";
import Footer from "./public-layout/Footer";

const Index = ({ classes }) => {
    return (
        <div>
            <Header></Header>
            <div id="first-block">
                <div class="line">
                    <article class="s-12">Body</article>
                </div>
            </div>
            <Footer></Footer>
        </div>
    );
};

export default Index