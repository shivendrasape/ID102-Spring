import React from 'react';


export default class NewProduct extends React.Component{

	
	onSubmitUpdate(e){
        e.preventDefault()
        this.props.updateProductsData({id: this.refs.id.value,name: this.refs.name.value,type: this.refs.type.value,expiry: this.refs.expiry.value})
    }
    render(){
    	var id =this.props.params.id;
        console.log(id)
        console.log(this.props.myproducts)
        var index=this.props.myproducts.findIndex((u)=>{
            if(u.id==id)
            return true;
        })

        var currProduct=this.props.myproducts[index];
        
        return <div className="container">
            <form onSubmit={this.onSubmitUpdate.bind(this)}>
            
            Id:<input type="number" className="form-control" ref="id" value={currProduct.id} /><br/>
            Name:<input type="text" className="form-control" ref="name" placeholder={currProduct.name}/><br/>
           
            Type:<input type="text" className="form-control" ref="type" placeholder={currProduct.type}/><br/>
            Expiry:<input type="text" className="form-control" ref="expiry" placeholder={currProduct.expiry}/><br/>
          
            <input type='submit' className="btn btn-primary" value='Submit'/>

            </form>
            
            </div>
    }
}
      
   