// src/components/characterselect.js

import React, {Component} from 'react'

class CharacterSelect extends Component {



  state = {
    actions: []
  }

  constructor(props){
    super(props)
    this.state.actions = props.actions
  }


    render (){
        var actions = this.props.actions
        return (<div>
                {actions.map((action) => {
                    return(
                        <p>
                            <strong>{action.name}:</strong>{action.description}
                        </p>
                    )
                }
                )
                }
            </div>
        );
    }
}

export default CharacterSelect
