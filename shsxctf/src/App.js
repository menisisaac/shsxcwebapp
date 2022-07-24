import Navbar from "./Navbar";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Dashboard from "./Dashboard";
import Home from "./Home";
import { useState } from "react";
import CrossCountry from "./CrossCountry";
import Indoortf from "./Indoortf";
import Outdoortf from "./Outdoortf";
import "bootstrap/dist/css/bootstrap.min.css";
import Grout from "./Grout";
import TestNavBar from "./TestNavBar";


function App() {
  const [token, setToken] = useState();
  return (
    <Router>
    <div className="App">
      {/* <Navbar/> */}
      <TestNavBar/>
      <div className='content'>
        <Switch>
          <Route exact path="/xc"><CrossCountry/></Route>
          <Route exact path='/grout'><Grout/></Route>
          <Route exact path='/indoortf'><Indoortf/></Route>
          <Route exact path='/outdoortf'><Outdoortf/></Route>
          <Route exact path="/admin"><Dashboard/></Route>
          <Route exact path="/"><Home/></Route>
        </Switch>
      </div>
    </div>
    </Router>
  );
}

export default App;
