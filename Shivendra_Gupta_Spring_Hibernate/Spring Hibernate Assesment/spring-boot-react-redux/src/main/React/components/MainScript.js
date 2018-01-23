import Main from './MainComponent';
import * as allActions from '../actions/actions';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';

function mapStateToProps(store){
    return{
        myproducts:store.products
    }
}

function mapDispatchToProps(dispatch){
    return bindActionCreators(allActions,dispatch)
}
var App=connect(mapStateToProps,mapDispatchToProps)(Main);
export default App;