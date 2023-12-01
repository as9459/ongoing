
CREATE OR REPLACE TRIGGER CheckLogementOccupancy
BEFORE INSERT ON Contrat_bail
FOR EACH ROW
DECLARE
    v_logement_empty BOOLEAN;
BEGIN
    v_logement_empty := IsLogementEmpty(:NEW.id_batiment, :NEW.id_logement, :NEW.date_debut);

    IF NOT v_logement_empty THEN
        RAISE_APPLICATION_ERROR(-20001, 'Le logement est occup�. Impossible d''ins�rer le contrat.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erreur dans le d�clencheur: ' || SQLERRM);
        ROLLBACK; -- Rollback the transaction in case of an error
END CheckLogementOccupancy;
/





CREATE OR REPLACE TRIGGER CheckLogementPaiementBIU
BEFORE INSERT OR UPDATE ON fact_logement
FOR EACH ROW
DECLARE
    v_amount_Paiement NUMBER;
    v_amount_HT NUMBER;
    v_TVA NUMBER;
    v_montant_aide NUMBER;
BEGIN
    
    if inserting  then
        select montant_HT, TVA, montant_de_l_aide into v_amount_HT, v_TVA, v_montant_aide
        from facture
        where id_facture = :NEW.id_facture
        and date_facture = :NEW.date_facture;
    else if updating then
        select montant_HT, TVA, montant_de_l_aide into v_amount_HT, v_TVA, v_montant_aide
        from facture
        where id_facture = :OLD.id_facture
        and date_facture = :OLD.date_facture;
    end if;
    end if;
    
    -- Calculate the total amount
    v_amount_Paiement := (v_amount_HT + (v_amount_HT * (v_TVA / 100))) - v_montant_aide;

    -- Check if Paiement is greater than the total amount
    IF :NEW.paiement > v_amount_Paiement THEN
        RAISE_APPLICATION_ERROR(-20001, 'Paiement cannot be greater than the total amount.');
    END IF;
END CheckLogementPaiementBIU;

/



CREATE OR REPLACE TRIGGER CheckBatimentPaiementBIU
BEFORE INSERT OR UPDATE ON fact_batiment
FOR EACH ROW
DECLARE
    v_amount_Paiement NUMBER;
    v_amount_HT NUMBER;
    v_TVA NUMBER;
    v_montant_aide NUMBER;
BEGIN
    
    if inserting  then
        select montant_HT, TVA, montant_de_l_aide into v_amount_HT, v_TVA, v_montant_aide
        from facture
        where id_facture = :NEW.id_facture
        and date_facture = :NEW.date_facture;
    else if updating then
        select montant_HT, TVA, montant_de_l_aide into v_amount_HT, v_TVA, v_montant_aide
        from facture
        where id_facture = :OLD.id_facture
        and date_facture = :OLD.date_facture;
    end if;
    end if;
    
    -- Calculate the total amount
    v_amount_Paiement := (v_amount_HT + (v_amount_HT * (v_TVA / 100))) - v_montant_aide;

    -- Check if Paiement is greater than the total amount
    IF :NEW.paiement > v_amount_Paiement THEN
        RAISE_APPLICATION_ERROR(-20001, 'Paiement cannot be greater than the total amount.');
    END IF;
END CheckBatimentPaiementBIU;

/















