const url = 'http://localhost:8080/P1-A-Rod1308/'

let formToggle = 0;

document.getElementById('getDisplayButton').addEventListener('click', displayFunc);
document.getElementById('toggleForm').addEventListener('click', toggleForm);

async function displayFunc() {

    if(document.getElementById("reimmbursmentTable").style.display = "none"){
        let response = await fetch(url + "app", {credentials: "include"});

        console.log(response);
      
        if(response.status === 200) { //if the request is successful...
            console.log(response); //just to see what comes back for debug
            console.log("2");
            let data = await response.json(); //get the JSON data from the response, turn it into JS object
            console.log("3");
            console.log(data);
            document.getElementById("reimmbursmentTable").style.display = "block";
    
            //now, I want to put each avenger into my table
            for(let reimbursment of data) { //for every avenger in the data variable/object
    
                console.log(reimbursment); //just for debug, print the avenger in the console
    
                let row = document.createElement("tr"); //create a table row
    
                let cell = document.createElement("td"); //create a cell for the field
                cell.innerHTML = reimbursment.reimb_id; //fill the cell with avenger data
                cell.className = "idColumn";
                row.appendChild(cell); //this row now has the first cell (av_id)
    
                let cell2 = document.createElement("td");
                cell2.innerHTML = reimbursment.reimb_amount;
                row.appendChild(cell2);
    
                let cell3 = document.createElement("td");
                cell3.innerHTML = reimbursment.reimb_submited;
                row.appendChild(cell3);
    
                let cell4 = document.createElement("td");
                cell4.innerHTML = reimbursment.reimb_resolved;
                row.appendChild(cell4);
    
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimbursment.reimb_description;
                row.appendChild(cell5);
    
                let cell6 = document.createElement("td");
                cell6.innerHTML = reimbursment.reimb_receipt;
                row.appendChild(cell6);
    
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimbursment.reimb_author;
                row.appendChild(cell7);
    
                let cell8 = document.createElement("td");
                cell8.innerHTML = reimbursment.reimb_resolver;
                row.appendChild(cell8);
    
                let cell9 = document.createElement("td");
                cell9.innerHTML = reimbursment.reimb_status_id;
                row.appendChild(cell9);
    
                let cell10 = document.createElement("td");
                cell10.innerHTML = reimbursment.reimb_status_id;
                row.appendChild(cell10);
                 document.getElementById("tableBody").appendChild(row);
               
            }
    
            let idColumnList = document.getElementsByClassName("idColumn");
            let select = document.getElementById("idSelect");
            for(let x of idColumnList){
                console.log(x.innerHTML);
    
                let option = document.createElement("option");
                option.value=x.innerHTML;
                option.innerHTML=x.innerHTML;
                option.className = "resolveIdClass";
                select.appendChild(option);
            }
    
            
           
    
        }
        
    
    }
	


}







/////////////////////////////////////////////////////////////





////////////////////////////////////////////////////////////////

function toggleForm() {
    if( document.getElementById("newReimbursmentForm").style.display = "none"){
	document.getElementById("newReimbursmentForm").style.display = "block"
}else {
	document.getElementById("newReimbursmentForm").style.display = "none"
}
		
	
}
