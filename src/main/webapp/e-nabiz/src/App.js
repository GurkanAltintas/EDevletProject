import {Container} from "reactstrap"
import Login from "./components/login/Login";
import Error from "./components/error/Error";
import Home from "./components/home/Home";
import Register from "./components/register/Register";
import {BrowserRouter, Switch, Route} from "react-router-dom";
import Imzagiris from "./components/imzagiris/Imzagiris";
import Admin from "./admin/Admin";
import AdminProcess from "./admin/AdminProcess";
import Duyuru from "./admin/Duyuru";
import Duyurularım from "./components/home/Duyurularım";
import FeedbackHome from "./components/home/feedback/FeedbackHome";
import Feedback from "./admin/Feedback";
import Hastalık from "./components/home/hastalık/Hastalık";
import Rapor from "./components/home/rapor/Rapor";
import Recete from "./components/home/recete/Recete";
import Ziyaret from "./components/home/ziyaret/Ziyaret";
import {Component} from "react";


export default class App extends Component {
    constructor(props) {
        super();
        this.state={
            tc:0
        }
    }
    setTC = (user) => {

        this.setState({tc:user})

        console.log(this.state.tc)
    }


    render() {
        return (
            <div>
                <Container>
                    <BrowserRouter>

                        <Switch>

                            <Route path="/" exact component={Login}/>
                            <Route path="/register" component={Register}/>
                            <Route path="/imza"> <Imzagiris func={this.setTC} tc={this.state.tc}/> </Route>
                            <Route path="/duyuru" component={Duyuru}/>
                            <Route path="/home/duyurular" component={Duyurularım}/>
                            <Route path="/admin" component={Admin}/>
                            <Route path="/geribildirim" component={FeedbackHome}/>
                            <Route path="/feedbacks" component={Feedback}/>
                            <Route path="/adminProcess" component={AdminProcess}/>
                            <Route path="/home" component={Home}/>
                            <Route path="/hastalik" component={Hastalık}/>
                            <Route path="/rapor" component={Rapor}/>
                            <Route path="/recete" component={Recete}/>
                            <Route path="/ziyaret"><Ziyaret tc={this.state.tc}/> </Route>
                            <Route exact component={Error}/>
                        </Switch>


                    </BrowserRouter>


                </Container>

            </div>
        );
    }
}

