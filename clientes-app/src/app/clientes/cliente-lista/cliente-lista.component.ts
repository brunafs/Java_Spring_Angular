import { Component, OnInit } from '@angular/core';
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from '../cliente';

@Component({
  selector: 'app-cliente-lista',
  templateUrl: './cliente-lista.component.html',
  styleUrls: ['./cliente-lista.component.css']
})
export class ClienteListaComponent implements OnInit {

  clientes: Cliente[] = [];

  constructor(private service: ClientesService) {

  }

  ngOnInit(): void {
    this.service
      .getClientes()
      .subscribe(resposta => {
        this.clientes = resposta;
      });
  }

}
