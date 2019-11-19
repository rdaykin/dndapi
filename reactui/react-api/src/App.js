import React, { Component } from 'react';
import Character from './components/character';
import CharacterForm from './components/characterform'

class CharacterView extends Component {

  state = {
    character: [],
    skills: []
  }

  constructor(props){
    super(props)
    fetch("http://localhost:8080/character/Adult Blue Dragon")
    .then(res => res.json())
    .then((data) => {
      console.log("DATA:" + data)
      this.state.character = data
    })
    .catch(console.log)
  }

  render () {
    console.log("Render time:" + JSON.stringify(this.state.character))
    return (
      <div><Character character={this.state.character} />
      <CharacterForm/>
      </div>
    );
  }

  componentDidMount() {
    fetch("http://localhost:8080/character/Ghost")
    .then(res => res.json())
    .then((data) => {
      console.log("DATA:" + JSON.stringify(data))
      this.setState({ character: data })
    })
    .catch(console.log)
  }
}

export default CharacterView;
