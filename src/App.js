import './App.css';
import React,{Component} from "react";

class App extends Component
{
  constructor(props) {

    super(props);
    this.state={count:0};
    console.log('constructor',this.state);
  }
  handleClick(event)
  {

    //alert(event.target.valueOf());
    const axios=require('axios');
      axios.get('http://54.179.218.221:8081/todos')
          .then(res=>{
              console.log(res.data);
          }).catch(error=>{
          console.error('Error',error);
      });
  }
  handlePostClick(event)
  {
    console.log('handlePostClick');
      const axios=require('axios');
    axios.post('http://54.179.218.221:8081/todos',{name:'packaging'})
        .then(res=>{
           console.log(res.data);
        }).catch(err=>{
            console.error('ERROR',err);
    });
  }
render() {
    return(
        <div className="App">
          <button onClick={this.handleClick.bind(this)} name="mybutton" value="test">Get All ToDos</button>
          <button onClick={this.handlePostClick.bind(this)}>Create New ToDo</button>
        </div>
    );
}
}
export default App