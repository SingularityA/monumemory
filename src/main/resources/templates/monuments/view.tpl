layout 'layout/main.tpl',
title:  'View Monument',
content: contents {
  h4(class:'header', 'Monument' + monument.name)
  div(class:'row') {}
  
  h5(class:'header', 'Description')
  div(class:'card-panel') {
    span(class:'brown-text text-darken-4', monument.description)
  }
  div(class:'row') {}
  
  h5(class:'header', 'History')
  div(class:'card-panel') {
    span(class:'brown-text text-darken-4', monument.history)
  }
  a (class:'waves-effect waves-light btn-large right deep-purple darken-1', href:sprintf(monumentUpdateUrl, monument.id)) {
    i (class:'material-icons left', 'edit')
    yield 'Edit'
  }
  a (class:'waves-effect waves-light btn-large right deep-purple darken-1', href:monumentListUrl) {
    i (class:'material-icons left', 'fast_rewind')
    yield 'Back to list'
  }
}