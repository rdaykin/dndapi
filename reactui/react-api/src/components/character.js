// src/components/skills.js

import React, {Component}  from 'react'
import SavingThrows from './savingthrows'
import Skills from './skills'
import Actions from './action'

class Character extends Component {

  state = {
    character:[]
  }

  constructor(props){
    super(props)
    this.state.character = props.character
  }

  render(){
    return (
      <center>
        <div>
          <h1>{this.props.character.name}</h1>
          <div>
            <strong>Armour Class</strong> {this.props.character.armourClass}<br/>
            <strong>Hit Points</strong> {this.props.character.hitpoints} ( {this.props.character.hitDice})<br/>
            <strong>Speed</strong> {this.props.character.speed}<br/>
          </div>
          <div>
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
                  <td>{this.props.character.strength}</td>
                  <td>{this.props.character.dexterity}</td>
                  <td>{this.props.character.constitution}</td>
                  <td>{this.props.character.intelligence}</td>
                  <td>{this.props.character.wisdom}</td>
                  <td>{this.props.character.charisma}</td>
                </tr>
              </tbody>
            </table>
          </div>
          {this.props.character.name ? <SavingThrows character={this.props.character}/>: null}
          {this.props.character.name ? <Skills character={this.props.character}/>: null}
          {this.props.character.resistances !== "" ? <strong>Damage Resistances </strong>:null} {this.props.character.resistances} {this.props.character.resistances != "" ? <br/>:null}
          {this.props.character.immunities !== "" ? <strong>Damage Immunities </strong>:null} {this.props.character.immunities} {this.props.character.immunities != "" ? <br/>:null}
          {this.props.character.conditionImmunities !== "" ? <strong>Condition Immunities </strong>:null} {this.props.character.conditionImmunities} {this.props.character.conditionImmunities != "" ? <br/>:null}
          {this.props.character.senses !== "" ? <strong>Senses </strong>:null} {this.props.character.senses} {this.props.character.senses != "" ? <br/>:null}
          {this.props.character.languages !== "" ? <strong>Languages </strong>:null} {this.props.character.languages} {this.props.character.languages != "" ? <br/>:null}
          <strong>Challenge</strong> {this.props.character.challengeRating}
          <h2>Special Abilities</h2>
          {this.props.character.actions? <Actions actions={this.props.character.actions}/>: null}
          <h2>Actions</h2>
          {this.props.character.actions? <Actions actions={this.props.character.specialAbilities}/>: null}
        </div>
      </center>
    )
  }
};

export default Character
