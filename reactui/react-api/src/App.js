import React, { Component } from 'react';
import Character from './components/character';
import CharacterForm from './components/characterform';
//import CharacterSelect from './componenets/characterselect';
/*import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';*/

class CharacterView extends Component {

  state = {
    character: [],
    skills: []
  }

  constructor(props){
    super(props)
    this.handleChange = this.handleChange.bind(this)
    this.setState = this.setState.bind(this)
    //this._renderActions = this._renderActions.bind(this);
  }

  render () {
    console.log("Render time:" + JSON.stringify(this.state.character))
    return (
      <div>
        <form onSubmit={this.submitForm}>
          <input type="text" id="name" onChange={this.handleChange}/>
          <input type="submit" value="Submit"/>
        </form>
        <Character character={this.state.character} />
        <CharacterForm/>
      </div>
    );
  }

  componentDidMount() {
    /*fetch("http://localhost:8080/character/Mr Average")
    .then(res => res.json())
    .then((data) => {
      console.log("MOUNT DATA:" + JSON.stringify(data))
      this.setState({ character: data })
    })
    .catch(console.log)*/
  }

  handleChange(event){
    /*const target = event.target;
    const value = target.value;
    const name = target.id;

    this.setState({
      [name]: value
    });*/
  }

  submitForm = (event) => {
    event.preventDefault();
    let currentComponent = this
    var characterlink = "http://localhost:8080/character/" + event.target[0].value
    console.log(currentComponent.state)
    fetch(characterlink)
    .then(res => res.json())
    .then((data) => {
      console.log("FORM DATA:" + JSON.stringify(data))
      currentComponent.setState({ character: data })
      console.log("State Set");
    })
    .catch(console.log)
  }

}

export default CharacterView;
