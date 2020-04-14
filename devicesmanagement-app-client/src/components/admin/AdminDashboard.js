import React, { Component } from 'react';
import { getAllUser } from '../../util/APIUtils';
import Table from './Table';



class AdminDashboard extends Component {

    constructor(props) {
        super(props);
        this.state = {
            accounts: []
        }

        // this.onChange = this.onChange.bind(this);
        this.logout = this.logout.bind(this);
    }

    logout(event) {
        event.preventDefault();
        this.props.onLogout();
    }

    componentDidMount() {
        getAllUser()
            .then(response => {
                console.log(response);
                this.setState({ accounts: response });
            })
            .catch(function (error) {
                console.log(error);
            })
    }

    // tabRow() {
    //     return this.state.accounts.map(function (object, i) {
    //         return <Table obj={object} key={i} 
    //             onDelete={this.props.onDelete}
    //         />;
    //     });
    // }

    render() {
        var elmAccoutns = this.state.accounts.map((account, index) => {
            return <Table key={account.id} index={index} obj={account} onDelete={this.props.onDelete}/>
        })

        return (
            <div>
                <h3 align="center">Persons List</h3>
                <table className="table table-striped" style={{ marginTop: 20 }}>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Active</th>
                        </tr>
                    </thead>
                    <tbody>
                        {/* {this.tabRow()} */}
                        {elmAccoutns}
                    </tbody>
                </table>
                {/* <Button onClick={this.logout} color="success" block>logout</Button> */}
            </div>
        );
    }
}

export default AdminDashboard;  