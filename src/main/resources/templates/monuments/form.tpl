layout 'layout/main.tpl',
title:  (isNewModel ? 'Create Monument' : 'Edit Monument'),
content: contents {
  h4(class:'header', 'Monument')
  form (class:'col s12', method:'post') {
    div(class:'row') {
      div (class:'input-field col s6') {
        inputAttrs = [id:'name', name:'name', type:'text', class:'validate', 'data-error': '', value: monumentDto.name]
        labelAttrs = [for:'name']
        
        if (errors && errors.hasFieldErrors('name')) {
          inputAttrs['class'] += ' invalid'
          inputAttrs['value'] = errors.getFieldValue('name')
          labelAttrs['data-error'] = errors.getFieldErrors('name')*.getDefaultMessage().join(', ')
        }
        
        input(inputAttrs)
        label(labelAttrs, 'Name')
      }
    }
    div(class:'row') {
      div (class:'input-field col s12') {
        inputAttrs = [id:'description', name:'description', type:'text', class:'materialize-textarea validate', 'data-error': '', value: monumentDto.description]
        labelAttrs = [for:'description']
        
        if (errors && errors.hasFieldErrors('description')) {
          inputAttrs['class'] += ' invalid'
          inputAttrs['value'] = errors.getFieldValue('description')
          labelAttrs['data-error'] = errors.getFieldErrors('description')*.getDefaultMessage().join(', ')
        }
        
        textarea(inputAttrs) {}
        label(labelAttrs, 'Description')
      }
    }
    div(class:'row') {
      div (class:'input-field col s12') {
        inputAttrs = [id:'history', name:'history', type:'text', class:'materialize-textarea validate', 'data-error': '', value: monumentDto.history]
        labelAttrs = [for:'history']
        
        if (errors && errors.hasFieldErrors('history')) {
          inputAttrs['class'] += ' invalid'
          inputAttrs['value'] = errors.getFieldValue('history')
          labelAttrs['data-error'] = errors.getFieldErrors('history')*.getDefaultMessage().join(', ')
        }
        
        textarea(inputAttrs) {}
        label(labelAttrs, 'History')
      }
    }
  
    button (class:'waves-effect waves-light btn-large right deep-purple darken-1') {
      i (class:'material-icons left', 'save')
      yield (isNewModel ? 'Create' : 'Update')
    }
    a (class:'waves-effect waves-light btn-large right deep-purple darken-1', href:monumentListUrl) {
      i (class:'material-icons left', 'cancel')
      yield 'Cancel'
    }
  }
}
script(type:'text/javascript', src:'/js/monument_form.js') {}
