
clear all;
% https://archive.ics.uci.edu/dataset/60/liver+disorders
entradas = readmatrix('SI.xlsx','Sheet','Entradas RNA')';
salidasDeseadas = readmatrix('SI.xlsx','Sheet','Salidas RNA')';

%Problema de Regresión
arquitecturas = {[1 1],[3 1],[5 1],[10 1],[15 1],[5 3],[8 3],[8 5],[10 5]};


for j = 1:length(arquitecturas)
    arquitectura = arquitecturas{j};
    
    errorEntrenamiento = [];
    errorValidacion = [];
    errorTest = [];
    
    for i=1:50
        
        rna = feedforwardnet(arquitectura);
        rna.trainParam.showWindow = false;
        [rna, tr] = train(rna, entradas, salidasDeseadas);
        disordersOuputsTest = sim(rna, entradas);
    
        errorEntrenamiento(end+1) =  tr.best_perf;
        errorValidacion(end+1)    =  tr.best_vperf; 
        errorTest(end+1)          =  tr.best_tperf;
        
    end 
    
    mediaErrorTest = mean(errorTest);
    desviacionTipica = std(errorTest);
    fprintf('Arquitectura [%d %d]\n   Entrenamiento: media %.2f  std %.2f\n   Validacion: media %.2f std %.2f\n   Test: media %.2f std %.2f\n',arquitectura, ...
            mean(errorEntrenamiento), std(errorEntrenamiento), mean(errorValidacion), ...
            std(errorValidacion), mean(errorTest), std(errorTest));
   
end
