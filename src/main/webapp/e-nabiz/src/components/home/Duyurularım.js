import React, {Component} from 'react';
import { Table } from 'reactstrap';
import alertify from "alertifyjs";
import Navbar from "./navbar/Navbar";


class Duyurularım extends Component {
    state={
        duyuru:[]
    }

    componentDidMount() {



        fetch('http://localhost:8080/api/user/admin/getAllAnnouncements')
            .then(response => response.json()).then(data =>
            this.setState({duyuru:data.data}))
            .catch(error => {
            console.log(error)
            alertify.error("Something gone wrong !");
        });
    }

    render() {
        return (
            <div>
                <Navbar/>
                <Table borderless>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Duyuru İçeriği</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.duyuru.map(item =>(

                            <tr key={item.id}>
                                <th scope="row">{item.id}</th>
                                <td>{item.announcement}</td>
                            </tr>
                        ))
                    }

                    </tbody>
                </Table>
            </div>
        );
    }
}

export default Duyurularım;