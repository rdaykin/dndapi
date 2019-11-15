// src/components/skills.js

import React, {Component} from 'react'

class CharacterForm extends Component {

  state = {

  }

  constructor (props){
    super(props);
    this.state = {
          name: "Rob",
          speed: 10,
          hitpoints: 10,
          strength: 10,
          dexterity: 10,
          constitution: 10,
          intelligence: 10,
          wisdom: 10,
          charisma: 10
    };

    this.handleChange = this.handleChange.bind(this)
    this.submitForm = this.submitForm.bind(this)

  }

  render(){
    return (
      <center>
        <div>
          <h1>New Character</h1>
          <div>
            <form onSubmit={this.submitForm}>
              <strong>NAME: </strong><input type="text" id="name" placeholder="NEW CHARACTER" onChange={this.handleChange}/><br/>
              <strong>SPEED: </strong><input type="number" id="speed" placeholder="speed" onChange={this.handleChange}/><br/>
              <strong>HITPOINTS: </strong><input type="number" id="hitpoints" placeholder="hitpoints" onChange={this.handleChange}/><br/>
              <table className="table table-bordered table-condensed">
                <thead>
                <tr>
                  <th><strong>STR</strong></th>
                  <th><strong>DEX</strong></th>
                  <th><strong>CON</strong></th>
                  <th><strong>INT</strong></th>
                  <th><strong>WIS</strong></th>
                  <th><strong>CHA</strong></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td><input type="number" id="strength" placeholder="10" onChange={this.handleChange}/></td>
                  <td><input type="number" id="dexterity" placeholder="10" onChange={this.handleChange}/></td>
                  <td><input type="number" id="constitution" placeholder="10" onChange={this.handleChange}/></td>
                  <td><input type="number" id="intelligence" placeholder="10" onChange={this.handleChange}/></td>
                  <td><input type="number" id="wisdom" placeholder="10" onChange={this.handleChange}/></td>
                  <td><input type="number" id="charisma" placeholder="10" onChange={this.handleChange}/></td>
                </tr>
                </tbody>
              </table>
              <input type="submit" value="Submit"/>
            </form>
          </div>
        </div>
      </center>
    )
  };

  handleChange(event){
    const target = event.target;
    const value = target.value;
    const name = target.id;

    this.setState({
      [name]: value
    });
    console.log("NAME:" + name + " VALUE:" + target.value)
  }

  submitForm(event){
    console.log(this.state)
    event.preventDefault();
    var postlink = 'http://localhost:8080/newcharacter/'
    + this.state.name
    + "?strength=" + this.state.strength
    + "&dexterity=" + this.state.dexterity
    + "&constitution=" + this.state.constitution
    + "&intelligence=" + this.state.intelligence
    + "&wisdom=" + this.state.wisdom
    + "&charisma=" + this.state.charisma
    + "&hitpoints=" + this.state.hitpoints
    + "&speed=" + this.state.speed
    fetch(postlink, {
     method: 'post',
     headers: {'Content-Type':'application/json'},
     body:
      this.state
    });
  }

}

export default CharacterForm
