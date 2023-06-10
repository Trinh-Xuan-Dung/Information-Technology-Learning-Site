/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

var moduleCounter = 1; // Counter for generating unique module names

function addModuleRow() {
    var table = document.querySelector("table"); // Get the table element
    var newRow = table.insertRow(-1); // Insert a new row at the last position (-1)

    var moduleNameCell1 = newRow.insertCell(0); // Insert a new cell for module name
    moduleNameCell1.innerHTML = '<p>Enter Name of Module </p>';
    var moduleNameCell2 = newRow.insertCell(1);
    moduleNameCell2.innerHTML = '<input type="text" name="moduleName' + moduleCounter + '">'; // Add an input field for module name
    var moduleNameCell3 = newRow.insertCell(2);
    moduleNameCell3.innerHTML = '<input type="button" name="btnnewWeek" value="New Week" onclick="addWeek(this)">';

    moduleCounter++; // Increment the module counter
}

function addWeek(button) {
    var moduleRow = button.parentNode.parentNode; // Get the module row
    var weekRow = moduleRow.insertAdjacentHTML('afterend', '<tr></tr>'); // Insert a new row after the module row

    var weekName = 'weekName' + moduleCounter; // Generate a unique name for the week input field

    weekRow.innerHTML = `
        <td><p>Enter Week Details</p></td>
        <td><input type="text" name="${weekName}"></td>
    `;
}