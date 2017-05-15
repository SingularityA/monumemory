layout 'layout/main.tpl',
title:  'Add Image',
content: contents {
  h4(class:'header', 'Add photo to ' + photoSet.description)
  form (class:'col s12', enctype: 'multipart/form-data', method:'post') {
    div(class:'row') {
      div (class:'input-field col s6') {
        inputAttrs = [id:'name', name:'name', type:'text', class:'validate', 'data-error': '']
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
      div (class:'file-field col s12') {
        inputAttrs = [id:'file', name:'file', type:'file']
        inputPathAttrs = [class: 'file-path validate', type:'text']

        if (errors && errors.hasFieldErrors('file')) {
          inputPathAttrs['class'] += ' invalid'
          div(class:'card-panel') {
            span(class:'brown-text text-darken-4', errors.getFieldErrors('file')*.getDefaultMessage().join(', '))
          }
        }
        div (class:'waves-effect waves-light btn deep-purple darken-1') {
          span('File')
          input(inputAttrs)
        }
        div (class:'file-path-wrapper') {
          input(inputPathAttrs)
        }
      }
    }
  
    button (class:'waves-effect waves-light btn-large right deep-purple darken-1', type:'submit') {
      i (class:'material-icons left', 'save')
      yield 'Save'
    }
    a (class:'waves-effect waves-light btn-large right deep-purple darken-1', href:sprintf(photoSetViewUrl, photoSet.id)) {
      i (class:'material-icons left', 'cancel')
      yield 'Cancel'
    }
  }
}
