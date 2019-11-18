import React, { Component } from 'react';
import Character from './components/character';
import CharacterForm from './components/characterform'
import Skills from './components/skills'

class CharacterView extends Component {

  state = {
        character: [],
        skills: []
  }

  render () {
    return (
      <div><Character character={this.state.character} />
      <CharacterForm/>
      <Skills skills={this.state.skills}/></div>
    );
  }

  componentDidMount() {
    fetch("http://localhost:8080/character/Fred")
    .then(res => res.json())
    .then((data) => {
      console.log(data)
      this.setState({ character: data })
    })
    .catch(console.log)
    fetch("http://localhost:8080/skills")
    .then(res => res.json())
    .then((data) => {
      console.log(data)
      this.setState({ skills: data })
    })
    .catch(console.log)
  }
}

export default CharacterView;
