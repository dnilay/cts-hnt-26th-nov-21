import React, { Component } from 'react';
import './App.css';
import {Route,Switch,Link} from "react-router-dom";
import GetAll from "./GetAll";
import Create from "./Create";
import Get from "./Get";
import Update from "./Update"
class App extends Component {
    render() {
        return (
            <div className="App">

                <Switch>
                    <Route exact path="/" component={GetAll}/>
                    <Route path="/Create" component={Create}/>
                </Switch>
                <Link to="/Create">Create</Link><br/>

            </div>
        );
    }
}

export default App;
