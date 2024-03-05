package com.application.services.importador.cadastro;

import com.application.entities.importador.BancoDeDadosEntity;
import com.application.entities.importador.ERPEntity;
import com.application.entities.importador.RamoEntity;
import com.application.services.importador.BancoDeDadosService;
import com.application.services.importador.ERPService;
import com.application.services.importador.RamoService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CadastroPerfilService {

    private final ERPService erpService;
    private final RamoService ramoService;
    private final BancoDeDadosService bancoDeDadosService;

    public CadastroPerfilService(RamoService ramoService, ERPService erpService, BancoDeDadosService bancoDeDadosService) {
        this.ramoService = ramoService;
        this.erpService = erpService;
        this.bancoDeDadosService = bancoDeDadosService;
    }

    public Collection<RamoEntity> getRamos() {
        return this.ramoService.getAll();
    }

    public Collection<ERPEntity> getERPs() {
        return this.erpService.getAll();
    }

    public Collection<BancoDeDadosEntity> getBancosDeDados() {
        return this.bancoDeDadosService.getAll();
    }
}
