layout 'layout/main.tpl',
title:  (isNewModel ? 'Create Photoset' : 'Edit Photoset'),
content: contents {
  h4(class:'header', 'Photoset')
  form (class:'col s12', method:'post') {
    div(class:'row') {
      div (class:'input-field col s12') {
        inputAttrs = [id:'description', name:'description', type:'text', class:'materialize-textarea validate', 'data-error': '', value: photoSetDto.description]
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
    button (class:'waves-effect waves-light btn-large right deep-purple darken-1', type:'submit') {
      i (class:'material-icons left', 'save')
      yield (isNewModel ? 'Create' : 'Update')
    }
    a (class:'waves-effect waves-light btn-large right deep-purple darken-1', href:sprintf(photoSetListUrl, monument.id)) {
      i (class:'material-icons left', 'cancel')
      yield 'Cancel'
    }
  }
}
script(type:'text/javascript', src:'/js/photo_set_form.js') {}
