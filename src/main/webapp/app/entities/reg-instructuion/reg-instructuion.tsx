import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IRegInstructuion } from 'app/shared/model/reg-instructuion.model';
import { getEntities } from './reg-instructuion.reducer';

export const RegInstructuion = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const regInstructuionList = useAppSelector(state => state.regInstructuion.entities);
  const loading = useAppSelector(state => state.regInstructuion.loading);

  useEffect(() => {
    dispatch(getEntities({}));
  }, []);

  const handleSyncList = () => {
    dispatch(getEntities({}));
  };

  return (
    <div>
      <h2 id="reg-instructuion-heading" data-cy="RegInstructuionHeading">
        <Translate contentKey="educationApp.regInstructuion.home.title">Reg Instructuions</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="educationApp.regInstructuion.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/reg-instructuion/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="educationApp.regInstructuion.home.createLabel">Create new Reg Instructuion</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {regInstructuionList && regInstructuionList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="educationApp.regInstructuion.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.regInstructuion.titleUz">Title Uz</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.regInstructuion.titleRu">Title Ru</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.regInstructuion.titleKr">Title Kr</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.regInstructuion.contentUz">Content Uz</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.regInstructuion.contentRu">Content Ru</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.regInstructuion.contentKr">Content Kr</Translate>
                </th>
                <th>
                  <Translate contentKey="educationApp.regInstructuion.status">Status</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {regInstructuionList.map((regInstructuion, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/reg-instructuion/${regInstructuion.id}`} color="link" size="sm">
                      {regInstructuion.id}
                    </Button>
                  </td>
                  <td>{regInstructuion.titleUz}</td>
                  <td>{regInstructuion.titleRu}</td>
                  <td>{regInstructuion.titleKr}</td>
                  <td>{regInstructuion.contentUz}</td>
                  <td>{regInstructuion.contentRu}</td>
                  <td>{regInstructuion.contentKr}</td>
                  <td>{regInstructuion.status ? 'true' : 'false'}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button
                        tag={Link}
                        to={`/reg-instructuion/${regInstructuion.id}`}
                        color="info"
                        size="sm"
                        data-cy="entityDetailsButton"
                      >
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/reg-instructuion/${regInstructuion.id}/edit`}
                        color="primary"
                        size="sm"
                        data-cy="entityEditButton"
                      >
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/reg-instructuion/${regInstructuion.id}/delete`}
                        color="danger"
                        size="sm"
                        data-cy="entityDeleteButton"
                      >
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="educationApp.regInstructuion.home.notFound">No Reg Instructuions found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default RegInstructuion;
