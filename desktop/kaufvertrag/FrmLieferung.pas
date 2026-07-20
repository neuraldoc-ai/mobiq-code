unit FrmLieferung;

interface

uses
  Vcl.Forms, Vcl.StdCtrls, Vcl.Controls, MobiqKaufvertrag, MobiqTexte;

type
  TFrmLieferung = class(TForm)
    cbxWunschtermin: TComboBox;
    edtLieferadresse: TEdit;
    cbxEtage: TComboBox;
    chkLiefersperre: TCheckBox;
    chkMontage: TCheckBox;
    procedure FormShow(Sender: TObject);
  private
    FKv: TKaufvertrag;
  end;

implementation

{$R *.dfm}

procedure TFrmLieferung.FormShow(Sender: TObject);
begin
  chkLiefersperre.Caption := Texte.Get(1203);
  chkLiefersperre.Checked := FKv.Liefersperre;
  chkMontage.Checked := FKv.HatMontage;
end;

end.
