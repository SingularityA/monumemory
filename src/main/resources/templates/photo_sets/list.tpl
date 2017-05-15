layout 'layout/main.tpl',
title:  'Photosets',
content: contents {
  h4(class:'header', 'Photosets for monument ' + monument.name)
  a (class:'waves-effect waves-light btn-large right deep-purple darken-1', href:sprintf(monumentViewUrl, monument.id)) {
    i (class:'material-icons left', 'fast_rewind')
    yield 'To Monument'
  }
  table(class: 'striped') {
    thead {
      tr {
        th('#')
        th('Description')
        th('Action')
      }
    }
    tbody {
      photoSets.eachWithIndex { photoSet, index ->
        tr {
          td(index + 1)
          td(photoSet.description)
          td {
            form (method:'post', action:sprintf(photoSetDeleteUrl, photoSet.id)) {
              a (class:'waves-effect waves-light btn-floating brown lighten-2', href:sprintf(photoSetViewUrl, photoSet.id)) {
                i (class:'material-icons left', 'pageview')
                yield 'View'
              }
              a (class:'waves-effect waves-light btn-floating brown lighten-2', href:sprintf(photoSetUpdateUrl, photoSet.id)) {
                i (class:'material-icons left', 'edit')
                yield 'Edit'
              }
              button (class:'waves-effect waves-light btn-floating brown lighten-2', type:'submit') {
                i (class:'material-icons left', 'delete')
                yield 'Delete'
              }
            }
          }
        }
      }
    }
  }
  div(class:'row') {}
  a (class:'waves-effect waves-light btn-large right deep-purple darken-1', href:sprintf(photoSetCreateUrl, monument.id)) {
    i (class:'material-icons left', 'add')
    yield 'Add'
  }
}
