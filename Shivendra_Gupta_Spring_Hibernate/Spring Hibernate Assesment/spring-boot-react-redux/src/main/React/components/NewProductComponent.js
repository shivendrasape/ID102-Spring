import React from 'react';

export default class NewProduct extends React.Component{

	
	onSubmit(e){
        e.preventDefault()
        this.props.saveProductsData({id: this.refs.id.value,name: this.refs.name.value,type: this.refs.type.value,expiry: this.refs.expiry.value})
    }
    render(){
        return <div className="container">
            <form onSubmit={this.onSubmit.bind(this)}>
            Id:<input type="number" className="form-control" ref="id"/><br/>
            Name:<input type="text" className="form-control" ref="name"/><br/>
           
            Type:<input type="text" className="form-control" ref="type"/><br/>
            Expiry:<input type="text" className="form-control" ref="expiry"/><br/>
            <input type='submit' className="btn btn-success" value='Submit'/>

            </form>
            
            </div>
    }
}
      
   