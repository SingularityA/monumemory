layout 'layout/main.tpl',
title:  'Monuments',
content: contents {
  h4(class:'header', 'Monuments')
  table(class: 'striped') {
    thead {
      tr {
        th('#')
        th('Name')
        th('Action')
      }
    }
    tbody {
      monuments.eachWithIndex { monument, index ->
        tr {
          td(index + 1)
          td(monument.name)
          td {
            form (method:'post', action:sprintf(monumentDeleteUrl, monument.id)) {
              a (class:'waves-effect waves-light btn-floating brown lighten-2', href:sprintf(monumentViewUrl, monument.id)) {
                i (class:'material-icons left', 'pageview')
                yield 'View'
              }
              a (class:'waves-effect waves-light btn-floating brown lighten-2', href:sprintf(monumentUpdateUrl, monument.id)) {
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
  a (class:'waves-effect waves-light btn-large right deep-purple darken-1', href:monumentCreateUrl) {
    i (class:'material-icons left', 'add')
    yield 'Add'
  }
}