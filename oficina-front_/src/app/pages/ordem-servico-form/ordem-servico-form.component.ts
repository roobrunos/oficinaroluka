import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { OrdemServicoService, OrdemServico } from '../../services/ordem-servico.service';
import { RouterModule, ActivatedRoute } from '@angular/router';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-ordem-servico-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    InputTextModule,
    DropdownModule,
    ButtonModule
  ],
  templateUrl: './ordem-servico-form.component.html',
  styleUrls: ['./ordem-servico-form.component.css']
})
export class OrdemServicoFormComponent implements OnInit {
  ordemForm!: FormGroup;
  statusOptions = ['ABERTA', 'EM ANDAMENTO', 'CONCLUÍDA'];
  ordemId?: number;

  constructor(
    private fb: FormBuilder,
    private ordemService: OrdemServicoService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.criarFormulario();

    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.ordemId = +id;
      this.ordemService.buscarPorId(this.ordemId).subscribe(ordem => {
        this.ordemForm.patchValue(ordem);
      });
    }
  }

  criarFormulario() {
    this.ordemForm = this.fb.group({
      codigo: ['', Validators.required],
      status: ['', Validators.required],
      cliente: ['', Validators.required],
      veiculo: ['', Validators.required]
    });
  }

  salvar() {
    if (this.ordemForm.valid) {
      const novaOrdem: OrdemServico = this.ordemForm.value;

      if (this.ordemId) {
        // Atualizar ordem
        this.ordemService.atualizar(this.ordemId, novaOrdem).subscribe({
          next: () => alert('Ordem de Serviço atualizada com sucesso!'),
          error: (err: any) => console.error('Erro ao atualizar', err)
        });
      } else {
        // Criar nova ordem
        this.ordemService.criar(novaOrdem).subscribe({
          next: () => {
            alert('Ordem de Serviço salva com sucesso!');
            this.ordemForm.reset();
          },
          error: (err: any) => console.error('Erro ao salvar', err)
        });
      }
    }
  }
}
