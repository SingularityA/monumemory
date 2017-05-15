layout 'layout/main.tpl',
title:  'View Photoset',
content: contents {
  h4(class:'header', 'Photoset for monument ' + monument.name)
  div(class:'row') {}
  
  h5(class:'header', 'Description')
  div(class:'card-panel') {
    span(class:'brown-text text-darken-4', photoSet.description)
  }
  div(class:'row') {}
  
  h5(class:'header', 'Photos')
  if ([].equals(photos)) {
    div(class:'card-panel') {
      span(class:'brown-text text-darken-4', 'No images found. Add new one!')
    }
  } else {
    div(class:'slider') {
      ul(class:'slides') {
        rootAttribute = '/img/'
        photos.each { photo ->
          li {
            img(src:rootAttribute + photo.path)
            div(class:'caption right-align') {
              h5(class: 'light grey-text text-lighten-3', photo.name)
            }
          }
        }
      }
    }
  }
  a (class:'waves-effect waves-light btn-large left deep-purple darken-1', href:sprintf(photoCreateUrl, photoSet.id)) {
    i (class:'material-icons left', 'add')
    yield 'Add'
  }
  a (class:'waves-effect waves-light btn-large right deep-purple darken-1', href:sprintf(photoSetUpdateUrl, photoSet.id)) {
    i (class:'material-icons left', 'edit')
    yield 'Edit'
  }
  a (class:'waves-effect waves-light btn-large right deep-purple darken-1', href:sprintf(photoSetListUrl, monument.id)) {
    i (class:'material-icons left', 'fast_rewind')
    yield 'Back to list'
  }
}
script(type:'text/javascript', src:'/js/photo_set_view.js') {}
