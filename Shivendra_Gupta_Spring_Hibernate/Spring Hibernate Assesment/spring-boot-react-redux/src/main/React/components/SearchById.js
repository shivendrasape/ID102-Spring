import React from 'react';
import {Link} from 'react-router';
import ReactDOM from 'react-dom'
export default class NewProduct extends React.Component{

	constructor(){
		super()
		this.state={value:"something"};
	}
	enteredText(){
		let enteredValue = ReactDOM.findDOMNode(this.refs.someValue)
		this.setState({value:enteredValue.value})
		}
	onSubmitFind(e){
        e.preventDefault()
        this.props.findByName({name: this.refs.name.value})
    }
    render(){
        return <div className="container">
            <form onChange={this.onSubmitFind.bind(this)}>
            Name:<input type="number" className="form-control" ref="someValue"  onChange={this.enteredText.bind(this)}/><br/>
  
       
            <Link to={`/view/${this.state.value}`}>
            <h3 className="btn btn-success">Submit</h3>
             </Link>

            </form>
            
            </div>
    }
}
      
   