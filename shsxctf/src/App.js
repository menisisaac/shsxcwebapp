import Navbar from "./Navbar";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Dashboard from "./Dashboard";
import Home from "./Home";
import { useState } from "react";
import Login from "./Login";
import CrossCountry from "./CrossCountry";
import Indoortf from "./Indoortf";
import Outdoortf from "./Outdoortf";


function App() {
  const [token, setToken] = useState();
  return (
    <Router>
    <div className="App">
      <Navbar/>
      <div className='content'>
        <Switch>
          <Route exact path="/xc"><CrossCountry/></Route>
          <Route exact path='/indoortf'><Indoortf/></Route>
          <Route exact path={'/outdoortf'}><Outdoortf/></Route>
          <Route exact path="/admin"><Dashboard/></Route>
          <Route exact path="/"><Home/></Route>
        </Switch>
      </div>
    </div>
    </Router>
  );
}

export default App;
