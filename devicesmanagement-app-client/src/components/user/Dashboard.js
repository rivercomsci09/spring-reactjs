import React, { Component } from 'react';
import { Button} from 'reactstrap';



class Dashboard extends Component {

    constructor() {
        super();
        this.state = {
            hasLoginFailed: false,
            showSuccessMessage: false
        }

        // this.onChange = this.onChange.bind(this);
        this.logout = this.logout.bind(this);
    }

    logout(event) {
        event.preventDefault();
        this.props.onLogout();
    }

    render() {
        return (
            <div>
                <Button onClick={this.logout} color="success" block>logout</Button>
            </div>
        );
    }
}

export default Dashboard;  