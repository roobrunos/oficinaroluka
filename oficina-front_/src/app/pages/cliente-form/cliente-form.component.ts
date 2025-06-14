import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Cliente, ClienteService } from '../../services/cliente.service';
import { ActivatedRoute, Router } from '@angular/router';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-cliente-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    InputTextModule,
    ButtonModule
  ],
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css']
})
export class ClienteFormComponent implements OnInit {
  clienteForm!: FormGroup;
  clienteId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private clienteService: ClienteService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.criarFormulario();

    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.clienteId = +id;
      this.clienteService.buscarPorId(this.clienteId).subscribe(cliente => {
        this.clienteForm.patchValue(cliente);
      });
    }
  }

  criarFormulario() {
    this.clienteForm = this.fb.group({
      nome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      telefone: ['', Validators.required]
    });
  }

  salvar() {
    if (this.clienteForm.valid) {
      const cliente: Cliente = this.clienteForm.value;

      if (this.clienteId) {
        this.clienteService.atualizar(this.clienteId, cliente).subscribe({
          next: () => {
            alert('Cliente atualizado com sucesso!');
            this.router.navigate(['/cliente-list']);
          },
          error: err => console.error('Erro ao atualizar', err)
        });
      } else {
        this.clienteService.criar(cliente).subscribe({
          next: () => {
            alert('Cliente criado com sucesso!');
            this.router.navigate(['/cliente-list']);
          },
          error: err => console.error('Erro ao criar cliente', err)
        });
      }
    }
  }
}
