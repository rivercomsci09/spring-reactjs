import React, { Component } from 'react';
// import { deleteUser } from '../../util/APIUtils'

class Table extends Component {

    constructor(props) {
        super(props);

    }

    delete = () => {
       this.props.onDelete(this.props.obj.id)  
    }

    render() {
        return (
            <tr>
                <td>
                    {this.props.obj.id}
                </td>
                <td>
                    {this.props.obj.username}
                </td>
                <td>
                    {this.props.obj.email}
                </td>
                <td>
                    <button className="btn btn-primary">Edit</button>
                </td>
                <td>
                    <button className="btn btn-danger" onClick={this.delete}>Delete</button>
                </td>
            </tr>
        );
    }
}

export default Table;