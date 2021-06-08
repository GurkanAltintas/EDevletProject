import { Container } from "reactstrap"
import Login from "./components/login/Login";
import Error from "./components/error/Error";
import Register from "./components/register/Register";
import { BrowserRouter,Switch, Route } from "react-router-dom";
function App() {
  return (
    <div className="App">
        <Container>
            <BrowserRouter>
                <Switch>
                    <Route path="/" exact component={Login}/>
                    <Route path="/register" component={Register}/>
                    <Route exact component={Error}/>
                    <Login/>
                </Switch>


            </BrowserRouter>




        </Container>

    </div>
  );
}

export default App;
