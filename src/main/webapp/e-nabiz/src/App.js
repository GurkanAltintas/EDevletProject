import { Container } from "reactstrap"
import Login from "./components/login/Login";
import Error from "./components/error/Error";
import Home from "./components/home/Home";
import Register from "./components/register/Register";
import { BrowserRouter,Switch, Route } from "react-router-dom";
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
function App() {
  return (
    <div className="App">
        <Container>
            <BrowserRouter>
                <Switch>
                    <Route path="/" exact component={Login}/>
                    <Route path="/register" component={Register}/>
                    <Route path="/imza" component={Imzagiris}/>
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
                    <Route path="/ziyaret" component={Ziyaret}/>
                    <Route exact component={Error}/>
                    <Login/>
                </Switch>


            </BrowserRouter>




        </Container>

    </div>
  );
}

export default App;
