/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {
    var cy = cytoscape({
        container: document.getElementById('grafo-container'),
        elements: [
         
            { data: { id: 'nodo1' } },
            { data: { id: 'nodo2' } },
            { data: { id: 'nodo3' } },
            { data: { id: 'nodo4' } },
            { data: { id: 'nodo5' } },
            { data: { id: 'nodo6' } },
            { data: { id: 'nodo7' } },
            { data: { id: 'nodo8' } },
            { data: { id: 'nodo9' } },
            { data: { id: 'arista1', source: 'nodo1', target: 'nodo2' } },
            { data: { id: 'arista2', source: 'nodo1', target: 'nodo3' } },
            { data: { id: 'arista3', source: 'nodo3', target: 'nodo4' } },
            { data: { id: 'arista4', source: 'nodo4', target: 'nodo2' } },
            { data: { id: 'arista5', source: 'nodo5', target: 'nodo6' } },
            { data: { id: 'arista6', source: 'nodo6', target: 'nodo7' } },
            { data: { id: 'arista7', source: 'nodo8', target: 'nodo7' } },
            { data: { id: 'arista8', source: 'nodo9', target: 'nodo8' } }
            
        ],
        style: [
            {
                selector: 'node',
                style: {
                    'background-color': '#AED6F1',
                    'label': 'data(id)',
                    'border-width': '2px',
                    'border-color': '#1B4F72'
                }
                
                
            }
        ],
      
    });
});