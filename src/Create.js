import React, { Component } from 'react';
import './App.css';

class Create extends Component {

  constructor(props){
    super(props);
    this.state = {product:{}};
  }



  onNameChange = (e)=>{
      console.log(e.target.value)
    this.setState({name:e.target.value});
  }
  onDescriptionChange = (e)=>{
    this.setState({description:e.target.value});
  }
  onPriceChange = (e)=>{
    this.setState({price:e.target.value});
  }

  createProduct(event){
    const axios = require('axios');
    axios.post('http://localhost:8081/products/',{productName:this.state.name,
              description:this.state.description,
              price:this.state.price})
              .then(res=>{
                    console.log(res.data);
                })
  }

  render() {
    return (
      <div>
        Enter Product Name:<input onChange={this.onNameChange}/><br/>
        Enter Product Description:<input onChange={this.onDescriptionChange}/><br/>
        Enter Product Price:<input onChange={this.onPriceChange}/><br/>
        <button onClick={this.createProduct.bind(this)}>Create Product</button>
        
      </div>
    );
  }
}

export default Create;
