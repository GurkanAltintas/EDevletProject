import React, {Component} from 'react';
import AdminNav from "./AdminNav";
import alertify from "alertifyjs";
import {Table} from "reactstrap";

class Feedback extends Component {

    state={
        feedbacks:[]
    }
    componentDidMount() {
        fetch('http://localhost:8080/api/user/getAllFeedBacks')
            .then(response => response.json()).then(data =>{
            console.log(data);
            this.setState({feedbacks:data.data})
        })
            .catch(error => {
                console.log(error)
                alertify.error("Something gone wrong !");
            });
    }

    render() {
        return (
            <div>
                <AdminNav/>
                <Table borderless>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>FeedBack</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.feedbacks.map(item =>(

                            <tr key={item.id}>
                                <th scope="row">{item.id}</th>
                                <td>{item.feedBack}</td>
                            </tr>
                        ))
                    }

                    </tbody>
                </Table>


            </div>
        );
    }
}

export default Feedback;