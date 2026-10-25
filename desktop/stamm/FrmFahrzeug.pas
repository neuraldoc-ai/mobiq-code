unit FrmFahrzeug;

interface

uses
  Vcl.Forms, Vcl.StdCtrls, Vcl.Controls, MobiqStamm;

type
  TFrmFahrzeug = class(TForm)
    edtKennzeichen: TEdit;
    edtLadevolumen: TEdit;
    edtZuladung: TEdit;
    cbxFiliale: TComboBox;
    chkKuehlung: TCheckBox;
  end;

implementation

{$R *.dfm}

end.
