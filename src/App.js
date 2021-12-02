import './App.css';
import React,{Component} from "react";

class App extends Component
{
    constructor(props) {
        super(props)
        this.state ={ todos: []};
        console.log('constructor');
    }
    componentDidMount(){
        console.log('componentDidMount');
        const axios = require('axios');
        axios.get('http://localhost:8081/todos/')
            .then(res=>{
                this.setState({todos : res.data});
            }).catch(error=>{
            console.error('Error',error)
        })
    }
componentDidUpdate(prevProps, prevState, snapshot) {
        console.log('componentDidUpdate');
}

    render() {
        let liElements = [];
        for(let todo of this.state.todos){
            liElements.push(<li>{todo.name}</li>);
        }
        return (
            <div className="App">
                <ul>{liElements}</ul>
            </div>
        );
    }

}


export default App